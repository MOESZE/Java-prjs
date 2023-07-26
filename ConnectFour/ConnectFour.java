import java.util.*;

public class ConnectFour {
  public static boolean Disk(char[][] field, int column, char color) {
    if (field[0][column] != ' ')
    return false;

    for (int row = 0; row < 6; ++row) {
      if (field[row][column] != ' ') {
        field[row - 1][column] = color;
        return true;
      }
    }
    field[5][column] = color;
    return true;
  }
  private static char getWinnerRows(char[][] field) {
    for (int row = 0; row < 6; ++row) {
      int count = 0;
      for (int column = 1; column < 7; ++column) {
        if (field[row][column] != ' ' && field[row][column] == field[row][column-1])
        ++count;
        else
        count = 1;
        
        if (count >= 4) {
          return field[row][column];
        }
      }
    }
    return ' ';
  }
  private static char getWinnerColumns(char[][] field) {
    for (int column = 0; column < 7; ++column) {
      int count = 0;
      for (int row = 1; row < 6; ++row) {
        if (field[row][column] != ' ' && field[row][column] == field[row-1][column])
        ++count;
        else count = 1;

        if (count >= 4) {
          return field[row][column];
        }
      }
    }
    return ' ';
  }
  private static char getWinnerDiagonals(char[][] field) {
    for (int column = 0; column < 7; ++column) {
      int count = 0;
      for (int row = 1; row < 6; ++row) {
        if (column + row >= 7)
        break;
        if (field[row][column+row] != ' ' && field[row-1][column + row - 1] == field[row][column+row])
        ++count;
        else
        count = 1;

        if (count >= 4)
        return field[row][column+row];
      }
    }
    for (int row = 0; row < 6; ++row) {
      int count = 0;
      for (int column = 1; column < 7; ++column) {
        if (column + row >= 6)
        break;
        if (field[row + column][column] != ' ' && field[row+column - 1][column - 1] == field[row + column][column])
        ++count;
        else
        count = 1;
        
        if (count >= 4)
        return field[row + column][column];
      }
    }
    for (int column = 0; column < 7; ++column) {
      int count = 0;
      for (int row = 1; row < 6; ++row) {
        if (column - row < 0)
        break;
        if (field[row][column-row] != ' ' && field[row - 1][column - row + 1] == field[row][column-row])
        ++count;
        else
        count = 1;

        if (count >= 4)
        return field[row][column-row];
      }
    }
    for (int row = 0; row < 6; ++row) {
      int count = 0;
      for (int column = 5; column >= 0; --column) {
        if (column - row < 0)
        break;
        if (field[column - row][column] != ' ' && field[column - row - 1][column + 1] == field[column - row][column])
        ++count;
        else
        count = 1;

        if (count >= 4)
        return field[column - row][column];
      }
    }
    return ' ';
  }
  public static char getWinner(char[][] field) {
    char winner = getWinnerRows(field);
    if (winner != ' ')
    return winner;
    winner = getWinnerColumns(field);
    if (winner != ' ')
    return winner;
    winner = getWinnerDiagonals(field);
    if (winner != ' ')
    return winner;

    for (int i = 0; i < field.length; ++i)
    for (int j = 0; j < field[i].length; ++j)
    if (field[i][j] == ' ')
    return ' ';
    
    return 'D';
  }
  public static void printField(char[][] field) {
    for (int row = 0; row < 6; ++row) {
      System.out.print("| ");
      for (int col = 0; col < 7; ++col)
      System.out.print(field[row][col] + "| ");
      System.out.println();
    }
    for (int col = 0; col < 7; ++col)
    System.out.print("___");
    System.out.println();
  }
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    char[][] field = new char [6][7];
    for (int i = 0; i < 6; ++i)
    for (int j = 0; j < 7; ++j)
    field[i][j] = ' ';
    
    printField(field);

    boolean isRed = true;
    while (true) {
      if (isRed)
      System.out.println("Red player's turn");
      else
      System.out.println("Blue player's turn");
      System.out.print("Choose column 1-7 to drop a disk in: ");
      int column = userInput.nextInt();
      if (column < 1 || column > 7) {
        System.out.println("Columns should be a number from 1 to 7");
        continue;
      }
      if (!Disk(field, column - 1, isRed ? '1' : '2')) {
        System.out.println("This column is filled, choose another one.");
        continue;
      }
      printField(field);

      char result = getWinner(field);
      if (result == 'D') {
        System.out.println("It's a draw");
        break;
      }
      else if (result == '1') {
        System.out.println("Red player wins");
        break;
      }
      else if (result == '2') {
        System.out.println("Blue player wins");
        break;
      }
      isRed = !isRed;
    }
  }
}