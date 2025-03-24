import React, { useState } from 'react';
import { View, Text, TextInput, Button } from 'react-native';
import { Picker } from '@react-native-picker/picker';
import Toast from 'react-native-toast-message';
import globalStyles from '../styles/global';
import { Freelancer } from '../types/Freelancer';
import api from '../api';

const RegisterScreen = () => {
  const [form, setForm] = useState({
    name: '',
    email: '',
    password: '',
    specialization: '',
    skill: '',
    hourlyRate: '',
  });

  const handleChange = (field: keyof typeof form, value: string) => {
    setForm({ ...form, [field]: value });
  };

  const handleRegister = async () => {
    try {
      const response = await api.post<Freelancer>('/freelancers/register', {
        ...form,
        hourlyRate: parseFloat(form.hourlyRate),
      });

      Toast.show({
        type: 'success',
        text1: 'Freelancer Registered ✅',
        text2: `${response.data.name} (ID: ${response.data.id})`,
      });

      setForm({
        name: '',
        email: '',
        password: '',
        specialization: '',
        skill: '',
        hourlyRate: '',
      });
    } catch (error) {
      Toast.show({
        type: 'error',
        text1: 'Registration Failed ❌',
        text2: 'Something went wrong. Please try again.',
      });
    }
  };

  return (
    <View style={globalStyles.container}>
      <Text style={globalStyles.heading}>Register Freelancer</Text>

      <TextInput
        style={globalStyles.input}
        placeholder="Name"
        value={form.name}
        onChangeText={(text) => handleChange('name', text)}
      />

      <TextInput
        style={globalStyles.input}
        placeholder="Email"
        keyboardType="email-address"
        value={form.email}
        onChangeText={(text) => handleChange('email', text)}
      />

      <TextInput
        style={globalStyles.input}
        placeholder="Password"
        secureTextEntry
        value={form.password}
        onChangeText={(text) => handleChange('password', text)}
      />

      <Text style={{ marginBottom: 6, fontWeight: 'bold' }}>Specialization</Text>
      <View style={globalStyles.input}>
        <Picker
          selectedValue={form.specialization}
          onValueChange={(value) => handleChange('specialization', value)}
          style={{
            backgroundColor: 'transparent',
            borderWidth: 0,
            paddingLeft: 10,
          }}
        >
          <Picker.Item label="Select specialization..." value="" enabled={false} />
          <Picker.Item label="Web Development" value="Web Development" />
          <Picker.Item label="Mobile Development" value="Mobile Development" />
          <Picker.Item label="UI/UX Design" value="UI/UX Design" />
          <Picker.Item label="Data Science" value="Data Science" />
          <Picker.Item label="DevOps" value="DevOps" />
        </Picker>
      </View>

      <TextInput
        style={globalStyles.input}
        placeholder="Skill"
        value={form.skill}
        onChangeText={(text) => handleChange('skill', text)}
      />

      <TextInput
        style={globalStyles.input}
        placeholder="Hourly Rate"
        keyboardType="numeric"
        value={form.hourlyRate}
        onChangeText={(text) => handleChange('hourlyRate', text)}
      />

      <Button title="Register" onPress={handleRegister} />
    </View>
  );
};

export default RegisterScreen;
