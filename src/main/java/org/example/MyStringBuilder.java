package org.example;

import java.util.Stack;

public class MyStringBuilder {
    private StringBuilder builder;
    private Stack<Snapshot> history;

    public MyStringBuilder() {
        builder = new StringBuilder();
        history = new Stack<>();
        saveSnapshot();
    }

    public MyStringBuilder append(String str) {
        builder.append(str);
        saveSnapshot();
        return this;
    }

    public MyStringBuilder insert(int offset, String str) {
        builder.insert(offset, str);
        saveSnapshot();
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        builder.delete(start, end);
        saveSnapshot();
        return this;
    }

    public void undo() {
        if (history.size() > 1) {
            history.pop();
            Snapshot previous = history.peek();
            builder = new StringBuilder(previous.getState());
        } else {
            System.out.println("No snapshot has been found.");
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    private static class Snapshot {
        private final String state;

        public Snapshot(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    private void saveSnapshot() {
        history.push(new Snapshot(builder.toString()));
    }

    public MyStringBuilder clear() {
        builder.setLength(0);
        saveSnapshot();
        return this;
    }
}
