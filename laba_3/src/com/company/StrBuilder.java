package com.company;

import java.util.Stack;

public class StrBuilder {
    public interface Action{
        void exec();
        void undo();
    }

    private StringBuilder stringBuilder;
    public Stack <Action> actions = new Stack<>();

    //Constructs a string builder with no characters in it and an initial capacity of 16 characters.
    private StrBuilder() {
        stringBuilder = new StringBuilder();
    }
    //Constructs a string builder that contains the same characters as the specified CharSequence.
    private StrBuilder(CharSequence seq) {
        stringBuilder = new StringBuilder(seq);
    }
    //Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.
    private StrBuilder(int capacity) {
        stringBuilder = new StringBuilder(capacity);
    }
    //Constructs a string builder initialized to the contents of the specified string.
    StrBuilder(String str) {
        stringBuilder = new StringBuilder(str);
    }
    //Returns a string representing the data in this sequence.
    public String toString() {
        return stringBuilder.toString();
    }
    //Appends the string representation of the boolean argument to the sequence.
    public StrBuilder append(boolean b)
    {
        String appended = String.valueOf(b);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(b);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the char argument to this sequence.
    public StrBuilder append(char c)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(c);
            }

            @Override
            public void undo() {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the char array argument to this sequence.
    public StrBuilder append(char[] str)
    {
        String appended = String.valueOf(str);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of a subarray of the char array argument to this sequence.
    public StrBuilder append(char[] str, int offset, int len)
    {
        String appended = String.valueOf(str).substring(offset,offset + len);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str, offset, len);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the specified character sequence to this Appendable.
    public StrBuilder append(CharSequence s)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(s);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - s.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends a subsequence of the specified CharSequence to this sequence.
    public StrBuilder append(CharSequence s, int start, int end)
    {
        String appended = String.valueOf(s).substring(start, end);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(s, start, end);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the double argument to this sequence.
    public StrBuilder append(double d)
    {
        String appended = String.valueOf(d);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(d);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the float argument to this sequence.
    public StrBuilder append(float f)
    {
        String appended = String.valueOf(f);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(f);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the int argument to this sequence.
    public StrBuilder append(int i)
    {
        String appended = String.valueOf(i);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(i);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Appends the string representation of the long argument to this sequence.
    public StrBuilder append(long lng)
    {
        String appended = String.valueOf(lng);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(lng);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }
    //Appends the string representation of the Object argument.
    public StrBuilder append(Object o)
    {
        String appended = String.valueOf(o);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(o);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }
    //Appends the specified string to this character sequence.
    public StrBuilder append(String str) {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length() - 1,
                        stringBuilder.length());
            }
        };


        actions.add(action);
        action.exec();
        return this;
    }
    //Appends the specified StringBuffer to this sequence.
    public StrBuilder append(StringBuffer sb)
    {
        String appended = String.valueOf(sb);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.append(sb);
            }

            @Override
            public void undo() {
                stringBuilder.delete(stringBuilder.length() - appended.length(), stringBuilder.length());
            }
        };

        action.exec();
        actions.push(action);
        return this;
    }
    //Removes the characters in a substring of this sequence.
    public StrBuilder delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.delete(start, end);
            }

            @Override
            public void undo() {
                stringBuilder.insert(start, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }
    //Removes the char at the specified position in this sequence.
    public StrBuilder deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        ;
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.deleteCharAt(index);
            }

            @Override
            public void undo() {
                stringBuilder.insert(index, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }
    //Replaces the characters in a substring of this sequence with characters in the specified String.
    public StrBuilder replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);

        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.replace(start, end, str);;
            }

            @Override
            public void undo() {
                stringBuilder.replace(start, end, deleted);
            }
        };

        action.exec();
        actions.add(action);
        return this;
    }
    //Inserts the string representation of a subarray of the str array argument into this sequence.
    public StrBuilder insert(int index, char[] str, int offset, int len) {
        String inserted = String.valueOf(str).substring(offset, offset + len);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(index, str, offset, len);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + inserted.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Inserts the string into this character sequence.
    public StrBuilder insert(int offset, String str) {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, str);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + str.length());
            }
        };

        action.exec();
        actions.push(action);
        ;
        return this;
    }
    //Inserts the string representation of the boolean argument into this sequence.
    public StrBuilder insert(int offset, boolean b)
    {
        String inserted = String.valueOf(b);
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, b);
            }

            @Override
            public void undo() {
                stringBuilder.delete(offset, offset + inserted.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Inserts the string representation of the char argument into this sequence.
    public StrBuilder insert(int offset, char c)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(offset, c);;
            }

            @Override
            public void undo() {
                stringBuilder.deleteCharAt(offset);
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
    //Inserts the specified CharSequence into this sequence.
    public StrBuilder insert(int dstOffset, CharSequence s)
    {
        Action action = new Action() {
            @Override
            public void exec() {
                stringBuilder.insert(dstOffset, s);
            }

            @Override
            public void undo() {
                stringBuilder.delete(dstOffset, dstOffset + s.length());
            }
        };

        action.exec();
        actions.push(action);

        return this;
    }
}