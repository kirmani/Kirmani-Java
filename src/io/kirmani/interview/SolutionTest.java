/*
 * Solution.java
 * Copyright (C) 2015 sean <sean@Seans-MBP.lan>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Paths;

public class SolutionTest {
    private static final String INPUT_PREFIX = "input";
    private static final String OUTPUT_PREFIX = "output";
    private static final String ACTUAL_PREFIX = "actual";
    private static final String TESTCASE_FILE_EXTENSION = ".txt";
    private static final String JAR_PATH =
            Paths.get("./build/jar/kirmani_io.jar").toAbsolutePath().normalize().toString();
    private static final String TEST_DIRECTORY =
            Paths.get("./src/io/kirmani/interview/").toAbsolutePath().normalize().toString();
    private static final String FAILURE_DELIMITER = "------------------------";

    public static void main(String[] args) throws FileNotFoundException, IOException,
           InterruptedException {
        for (File f : new File(TEST_DIRECTORY).listFiles()) {
            if (f.isDirectory()) {
                String directory = f.getName();
                List<TestCase> testCases = getTestCases(directory);
                System.out.println(String.format("Running %d test case(s) for %s...",
                            testCases.size(), directory));
                for (TestCase testCase : testCases) {
                    runTestCase(testCase, directory);
                }
            }
        }
    }

    private static void runTestCase(TestCase testCase, String directory)
            throws FileNotFoundException, IOException, InterruptedException {
        InputStream inputStream = new FileInputStream(testCase.getInput());
        InputStream outputStream = new FileInputStream(testCase.getOutput());
        String actualFile = String.format(
                "%s/%s/%s%02d%s", TEST_DIRECTORY, directory, ACTUAL_PREFIX, testCase.getIndex(),
                TESTCASE_FILE_EXTENSION);
        InputStream stdin = System.in;
        File actualFileOutput = new File(actualFile);
        ProcessBuilder processBuilder = new ProcessBuilder("java","-cp", JAR_PATH,
                String.format("io.kirmani.interview.%s.Solution", directory));
        processBuilder.redirectInput(testCase.getInput());
        processBuilder.redirectOutput(actualFileOutput);
        processBuilder.redirectError(actualFileOutput);
        Process process = processBuilder.start();
        process.waitFor();
        InputStream actualStream = new FileInputStream(actualFileOutput);
        String input = streamString(inputStream);
        String expected = streamString(outputStream);
        String actual = streamString(actualStream);
        if (!expected.equals(actual)) {
            System.out.println(FAILURE_DELIMITER);
            System.out.println(String.format("Test Case #%d FAILED%n", testCase.getIndex()));
            System.out.println(String.format("Input (stdin)", testCase.getIndex()));
            System.out.println(input);
            System.out.println(String.format("Your Output (stdout)", testCase.getIndex()));
            System.out.println(expected);
            System.out.println(String.format("Expected Output", testCase.getIndex()));
            System.out.print(actual);
            System.out.println(String.format("%s%n", FAILURE_DELIMITER));
        } else {
            System.out.println(String.format("Test Case #%d PASSED", testCase.getIndex()));
        }
        inputStream.close();
        outputStream.close();
        actualStream.close();
    }

    private static String streamString(InputStream inputStream) throws IOException {
        return new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
    }

    private static List<TestCase> getTestCases(String directory) {
        List<TestCase> testCases = new ArrayList<>();
        int index = 0;
        boolean done = false;
        while (!done) {
            String inputFile = String.format(
                    "%s/%s/%s%02d%s", TEST_DIRECTORY, directory, INPUT_PREFIX, index,
                    TESTCASE_FILE_EXTENSION);
            String outputFile = String.format(
                    "%s/%s/%s%02d%s", TEST_DIRECTORY, directory, OUTPUT_PREFIX, index,
                    TESTCASE_FILE_EXTENSION);
            File input = new File(inputFile);
            File output = new File(outputFile);
            if (input.exists() && output.exists()) {
                testCases.add(new TestCase(input, output, index));
            } else if (input.exists()) {
                System.out.println(String.format(
                            "Found test input file %s, missing test output file %s", inputFile,
                            outputFile));
            } else if (output.exists()) {
                System.out.println(String.format(
                            "Found test output file %s, missing test input file %s", outputFile,
                            inputFile));
            } else {
                done = true;
            }
            index++;
        }
        return testCases;
    }

    private static class TestCase {
        private File mInput;
        private File mOutput;
        private int mIndex;

        public TestCase(File input, File output, int index) {
            mInput = input;
            mOutput = output;
            mIndex = index;
        }

        private File getInput() {
            return mInput;
        }

        private File getOutput() {
            return mOutput;
        }

        private int getIndex() {
            return mIndex;
        }
    }
}
