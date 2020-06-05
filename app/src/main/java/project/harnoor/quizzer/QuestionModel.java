package project.harnoor.quizzer;

public class QuestionModel {
        private String question,optionA,optionB,optionC,optionD,checkANS;
        private int setNo;

        public QuestionModel(){

        }
    public QuestionModel(String question, String optionA, String optionB, String optionC, String optionD, String checkANS, int setNo) {
            this.setNo = setNo;
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.checkANS = checkANS;
        }

    public String getCheckANS() {
        return checkANS;
    }

    public void setCheckANS(String checkANS) {
        this.checkANS = checkANS;
    }

    public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getOptionA() {
            return optionA;
        }

        public void setOptionA(String optionA) {
            this.optionA = optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public void setOptionB(String optionB) {
            this.optionB = optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public void setOptionC(String optionC) {
            this.optionC = optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public void setOptionD(String optionD) {
            this.optionD = optionD;
        }

        public int getSetNo() {
            return setNo;
        }

        public void setSetNo(int setNo) {
            this.setNo = setNo;
        }
    }


