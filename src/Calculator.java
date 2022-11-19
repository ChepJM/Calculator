public class Calculator {

    String statement;
    int[] numbers;
    String[] actions;
    int[] order;


    public Calculator(String statement)
    {
        Validator.validateSymbols(statement);
        Validator.validatePattern(statement);
        this.statement = statement;
        statement = statement.replaceAll(" ", "");
        this.numbers = getNumbers(statement);
        Validator.validateNumbersSize(this.numbers);
        this.actions = getActions(statement);
        this.order = getOrder(this.actions);
    }

    private int[] getNumbers(String statement)
    {
        String[] strNumbers = statement.split("[\\+\\-\\*\\/]");
        int[] numbers = new int[strNumbers.length];
        for (int i=0; i < strNumbers.length; i++)
        {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        return numbers;
    }

    private String[] getActions(String statement)
    {
        return statement.replaceAll("[0-9]", "").split("");
    }

    private int[] getOrder(String[] actions)
    {
        int[] order = new int[actions.length];
        int actionCount = 0;
        for (int i=0; i < order.length; i++)
        {
            if ((actions[i].equals("*")) || (actions[i].equals("/")))
            {
                order[actionCount] = i;
                actionCount++;
            }
        }
        for (int i=0; i < order.length; i++)
        {
            if ((actions[i].equals("+")) || (actions[i].equals("-")))
            {
                order[actionCount] = i;
                actionCount++;
            }
        }
        return order;
    }

    public int calculate()
    {
        int result = 0;
        int index = 0;
        for (int action : this.order)
        {
            index = action;
            switch (this.actions[action])
            {
                case "*":
                    result = this.numbers[index] * this.numbers[index + 1];
                    break;
                case "/":
                    result = this.numbers[index] / this.numbers[index + 1];
                    break;
                case "+":
                    result = this.numbers[index] + this.numbers[index + 1];
                    break;
                case "-":
                    result = this.numbers[index] - this.numbers[index + 1];
                    break;
            }
            this.numbers[index] = result;
            this.numbers[index + 1] = result;
        }

        return this.numbers[this.order[this.order.length - 1]];
    }
}
