package com.domain.lesson13Exception;

public class Message {



        private String title;
        private String text;

    public Message(String title, String text) throws CheckedException {
            setTitle(title);
            setText(text);

        }

        public String getTitle () {
            return title;
        }

        public String getText () {
            return text;
        }

        public void setTitle (String title) throws CheckedException {
            if (title == null || title.trim().length() < 3) {
//                throw new UncheckedException("длина менее 3 символов");
                throw new CheckedException("длина менее 3 символов");
            }
            this.title = title;
        }

        public void setText (String text)  throws CheckedException {
            if (text == null || text.trim().length() < 10) {
//                throw new UncheckedException("длина менее 3 символов");
                throw new CheckedException("длина менее 3 символов");
            }
            this.text = text;
        }
    public static void main(String[] args) {
        Message message = null;
        try {
             message = new Message("тема", "текст");
        } catch (CheckedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
