import React, { useState } from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import RegisterScreen from "../screens/RegisterScreen";
import AddProjectScreen from "../screens/AddProjectScreen";
import SearchScreen from "../screens/SearchScreen";
import globalStyles from "../styles/global";

const HomeTabs = () => {
  const [activeTab, setActiveTab] = useState<"Register" | "Add" | "Search">(
    "Register"
  );

  const renderScreen = () => {
    switch (activeTab) {
      case "Register":
        return <RegisterScreen />;
      case "Add":
        return <AddProjectScreen />;
      case "Search":
        return <SearchScreen />;
    }
  };

  return (
    <View style={{ flex: 1 }}>
      {/* Top Tabs */}
      <View style={styles.tabContainer}>
        <TouchableOpacity
          style={[
            styles.tabButton,
            activeTab === "Register" && styles.activeTab,
          ]}
          onPress={() => setActiveTab("Register")}
        >
          <Text style={styles.tabText}>Register</Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={[styles.tabButton, activeTab === "Add" && styles.activeTab]}
          onPress={() => setActiveTab("Add")}
        >
          <Text style={styles.tabText}>Add Project</Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={[styles.tabButton, activeTab === "Search" && styles.activeTab]}
          onPress={() => setActiveTab("Search")}
        >
          <Text style={styles.tabText}>Search Projects</Text>
        </TouchableOpacity>
      </View>

      {/* Render Selected Screen */}
      <View style={{ flex: 1 }}>{renderScreen()}</View>
    </View>
  );
};

const styles = StyleSheet.create({
  tabContainer: {
    flexDirection: "row",
    backgroundColor: "#f2f2f2",
    paddingHorizontal: 4,
    paddingVertical: 8,
  },
  tabButton: {
    flex: 1,
    marginHorizontal: 4,
    paddingVertical: 6,
    borderRadius: 6,
    borderWidth: 1,
    borderColor: "#ccc",
    backgroundColor: "#fff",
    alignItems: "center",
  },
  activeTab: {
    backgroundColor: "#007bff",
    borderColor: "#007bff",
  },
  tabText: {
    fontSize: 13,
    fontWeight: "600",
    color: "#000",
  },
});

export default HomeTabs;
