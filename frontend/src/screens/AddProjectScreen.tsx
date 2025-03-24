import React, { useState } from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import { Project } from '../types/Project';
import globalStyles from '../styles/global';
import api from '../api';
import Toast from 'react-native-toast-message';

const AddProjectScreen = () => {
  const [form, setForm] = useState({
    title: '',
    description: '',
    technologies: '',
    freelancerId: '',
  });

  const handleChange = (field: string, value: string) => {
    setForm({ ...form, [field]: value });
  };

  const handleSubmit = async () => {
    try {
      const techList = form.technologies.split(',').map((t) => t.trim());

      const response = await api.post('/portfolio/add', {
        title: form.title,
        description: form.description,
        technologiesUsed: techList,
        freelancer: {
          id: parseInt(form.freelancerId),
        },
      });

      const data = response.data as Project;

      Toast.show({
        type: 'success',
        text1: 'Project Added ✅',
        text2: `Project "${data.title}" created successfully.`,
      });

      setForm({ title: '', description: '', technologies: '', freelancerId: '' });
    } catch (error) {
      Toast.show({
        type: 'error',
        text1: 'Failed to Add Project ❌',
        text2: 'Something went wrong. Please try again.',
      });
    }
  };

  return (
    <View style={globalStyles.container}>
      <Text style={globalStyles.heading}>Add Project</Text>

      <TextInput
        style={globalStyles.input}
        placeholder="Project Title"
        value={form.title}
        onChangeText={(text) => handleChange('title', text)}
      />
      <TextInput
        style={globalStyles.input}
        placeholder="Description"
        value={form.description}
        onChangeText={(text) => handleChange('description', text)}
      />
      <TextInput
        style={globalStyles.input}
        placeholder="Technologies (comma-separated)"
        value={form.technologies}
        onChangeText={(text) => handleChange('technologies', text)}
      />
      <TextInput
        style={globalStyles.input}
        placeholder="Freelancer ID"
        keyboardType="numeric"
        value={form.freelancerId}
        onChangeText={(text) => handleChange('freelancerId', text)}
      />

      <Button title="Add Project" onPress={handleSubmit} />
    </View>
  );
};

export default AddProjectScreen;
