package ie.atu.serialization.objectserialization;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		// Define a constant for the file path where the serialized object will be stored
		final String FILE_PATH = "./resources/employee.ser";

		// Create an Employee object
		Employee employeeBeforeSerialization = new Employee("827384773H", "Collins");

		// Print the details of the employee before serialization
		System.out.println("Before Serialization: " + employeeBeforeSerialization);

		// Try-with-resources block to handle the serialization
		try (
			// Create a FileOutputStream to write to the specified file path
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			// Create an ObjectOutputStream to write objects to the FileOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(fos)
		) {
			// Write the employee object to the ObjectOutputStream
			oos.writeObject(employeeBeforeSerialization);
			// Indicate that the employee object has been serialized
			System.out.println("Employee object has been serialized!");
		} catch (IOException ex) {
			// Print any IOException that occurs during serialization
			ex.printStackTrace();
		}

		// Try-with-resources block to handle the deserialization
		try (
			// Create a FileInputStream to read from the specified file path
			FileInputStream fis = new FileInputStream(FILE_PATH);
			// Create an ObjectInputStream to read objects from the FileInputStream
			ObjectInputStream ois = new ObjectInputStream(fis)
		) {
			// Read the employee object from the ObjectInputStream
			Employee employeeAfterDeserialization = (Employee) ois.readObject();
			// Indicate that the employee object has been deserialized
			System.out.println("Employee object has been deserialized");
			// Print the details of the employee after deserialization
			System.out.println("After Deserialization: " + employeeAfterDeserialization);
		} catch (IOException | ClassNotFoundException ex) {
			// Print any IOException or ClassNotFoundException that occurs during deserialization
			ex.printStackTrace();
		}
	}
}