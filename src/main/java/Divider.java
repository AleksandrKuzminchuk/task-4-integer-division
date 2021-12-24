package main.java;

public class Divider {

    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder reminder= new StringBuilder();

    public String dividesTheNumbersIntoColumns(int divisible, int divider) {

        requiredNonZero(divider);

        divisible = Math.abs(divisible);
        divider = Math.abs(divider);

        if (divisible < divider) {
            return "" + divisible + "/" + divider + "=0";
        }

        String[] digits = String.valueOf(divisible).split("");
        Integer reminderNumber;
        Integer multiplyResult;
        Integer dividerDigit = calculatesDigit(divider);
        Integer module;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= divider) {
                module = reminderNumber % divider;
                multiplyResult = reminderNumber / divider * divider;

                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber);
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(multiply).append("\n");

                Integer tab = lastReminder.length() - calculatesDigit(multiplyResult);
                result.append(makeDivider(reminderNumber, tab)).append("\n");

                quotient.append(reminderNumber / divider);

                reminder.replace(0, reminder.length(), module.toString());
                reminderNumber = Integer.parseInt(reminder.toString());
            } else {
                if (i >= dividerDigit) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", reminderNumber)).append("\n");
            }
        }
        changesTheResultForViewing(divisible, divider);
        return result.toString();
    }

    private String makeDivider(Integer reminderNumber, Integer tab) {
        return joinString(tab, ' ') + joinString(calculatesDigit(reminderNumber), '-');
    }

    private void changesTheResultForViewing(Integer divisible, Integer divider) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = calculatesDigit(divisible) + 1 - index[0];
        result.insert(index[2], joinString(tab, ' ') +"│" + quotient.toString());
        result.insert(index[1], joinString(tab, ' ') +"│" + joinString(quotient.length(), '-'));
        result.insert(index[0], "│" + divider);
        result.replace(1, index[0], divisible.toString());
    }

    private int calculatesDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
    private String joinString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    private void requiredNonZero(Integer number) {
         if(number == 0){
            throw new IllegalArgumentException("You cannot divide by 0!");
        }
    }
}
