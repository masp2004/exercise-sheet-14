package de.unistuttgart.iste.sqa.pse.sheet14.presence.collectionstreams;

import java.util.*;

/**
 * In this class you are supposed to train your skills in using the Java Streams
 * API and Collections. Implement the four empty operations in this class
 * properly by using streams. Do not forget to use defensive programming and to
 * comment your code!
 */
public final class StreamsAndFilterExercise {

	public static void main(String[] args) {
		final StudentRecord record = new StudentRecord();
		DataGenerator.fillRecordWithTestData(record);
		DataGenerator.fillRecordWithRealLifePSEMarks(record);

		System.out.println("--------------------------");
		System.out.println("TEST FOR STREAMS + LAMBDAS:");
		System.out.println("--------------------------");

		System.out.println();
		System.out.println("1) All student names:");
		printAllStudentNames(record);
		System.out.println();
		System.out.println("2) Number of students older than 23:");
		printNumberOfStudentsOlderThan(record, 23);
		System.out.println();
		System.out.println("3) Students older than 23:");
		printStudentNamesOlderThan(record, 23);
		System.out.println();
		System.out.println("4) Students older than 25 and failed PSE:");
		printStudentNamesOlderThanAndFailedExam(record, 25, "PSE");
		System.out.println();

		System.out.println("--------------------------");
		System.out.println("TEST WITHOUT STREAMS + LAMBDAS:");
		System.out.println("--------------------------");

		System.out.println();
		System.out.println("1) All student names:");
		printAllStudentNamesChallenge(record);
		System.out.println();
		System.out.println("2) Number of students older than 23:");
		printNumberOfStudentsOlderThanChallenge(record, 23);
		System.out.println();
		System.out.println("3) Students older than 23:");
		printStudentNamesOlderThanChallenge(record, 23);
		System.out.println();
		System.out.println("4) Students older than 25 and failed PSE:");
		printStudentNamesOlderThanAndFailedExamChallenge(record, 25, "PSE");
	}

	private static void printAllStudentNames(final StudentRecord record) {
		record.getAllStudents().stream()
				.map(Student::getName)
				.forEach(System.out::println);
	}

	private static void printNumberOfStudentsOlderThan(final StudentRecord record, final int olderThan) {
		long count = record.getAllStudents().stream()
				.filter(student -> student.getAge() > olderThan)
				.count();
		System.out.println("Number of students older than " + olderThan + ": " + count);
	}

	private static void printStudentNamesOlderThan(final StudentRecord record, final int olderThan) {
		record.getAllStudents().stream()
				.filter(student -> student.getAge() > olderThan)
				.map(Student::getName)
				.forEach(System.out::println);
	}

	private static void printStudentNamesOlderThanAndFailedExam(
			final StudentRecord record, final int olderThan, final String exam) {
		record.getAllStudents().stream()
				.filter(student -> student.getAge() > olderThan)
				.filter(student -> student.getExam(exam).getMark() > 4.0)
				.map(Student::getName)
				.forEach(System.out::println);
	}

	private static void printAllStudentNamesChallenge(final StudentRecord record) {
		for (Student student : record.getAllStudents()) {
			System.out.println(student.getName());
		}
	}

	private static void printNumberOfStudentsOlderThanChallenge(final StudentRecord record, final int olderThan) {
		int count = 0;
		for (Student student : record.getAllStudents()) {
			if (student.getAge() > olderThan) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void printStudentNamesOlderThanChallenge(final StudentRecord record, final int olderThan) {
		Set<String> students = new HashSet<>();
		for (Student student : record.getAllStudents()) {
			if (student.getAge() > olderThan) {
				students.add(student.getName());
			}
		}
		for (String name : students) {
			System.out.println(name);
		}
	}

	private static void printStudentNamesOlderThanAndFailedExamChallenge(
			final StudentRecord record, final int olderThan, final String exam) {
		// TODO: implement exercise 1 (f)
	}
}
