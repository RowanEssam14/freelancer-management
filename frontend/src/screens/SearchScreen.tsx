import React, { useState } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  FlatList,
  StyleSheet,
} from "react-native";

import api from "../api";
import { Project } from "../types/Project";
import globalStyles from "../styles/global";


const SearchScreen = () => {
  const [query, setQuery] = useState("");
  const [results, setResults] = useState<Project[]>([]);

  const handleSearch = async () => {
    try {
      const response = await api.get(`/portfolio/search?query=${query}`);
      console.log("✅ API response:", response.data);
      setResults(Array.isArray(response.data) ? response.data : []);
    } catch (error) {
      console.error("Search failed:", error);
    }
  };

  return (
    <View style={globalStyles.container}>
      <Text style={globalStyles.heading}>Search Projects</Text>

      <TextInput
        style={globalStyles.input}
        placeholder="Search by title or technology..."
        value={query}
        onChangeText={setQuery}
      />
      <Button title="Search" onPress={handleSearch} />

      <FlatList
        data={results}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text style={styles.title}>{item.title}</Text>
            <Text style={styles.desc}>{item.description}</Text>
            <Text style={styles.techs}>
              🔧 {item.technologiesUsed?.join(", ") || "N/A"}
            </Text>
          </View>
        )}
        ListEmptyComponent={
          query.length > 0 ? (
            <Text style={styles.noResults}>
              No projects found for "{query}"
            </Text>
          ) : null
        }
      />
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: "#f9f9f9",
    padding: 14,
    marginTop: 12,
    marginBottom: 12,
    borderRadius: 8,
    elevation: 2,
  },
  title: {
    fontSize: 16,
    fontWeight: "bold",
  },
  desc: {
    marginTop: 4,
    color: "#555",
  },
  techs: {
    marginTop: 6,
    fontStyle: "italic",
    color: "#444",
  },
  noResults: {
    marginTop: 20,
    textAlign: "center",
    fontStyle: "italic",
    color: "#999",
  },
});

export default SearchScreen;
