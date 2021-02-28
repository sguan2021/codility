import java.util.*;

class Solution {

    //convert the string to seat row and column numbers
    protected int[] convertToSeat(String str) {
        int[] seat = new int[2];
        seat[0] = str.charAt(0) - '0';

        char seatName = str.charAt(1);
        switch (seatName) {
         case 'A':
         case 'B':
         case 'C':
         case 'D':
         case 'E':
         case 'F':
         case 'G':
         case 'H':
            seat[1] = seatName - 'A';
            break;
        case 'J':
        case 'K':
            seat[1] = seatName - 'A' -1;
            break;
        }
        return seat; 
    }

    //book on row, starting from col for 4 seats, this code is not scalable
    protected boolean book(int row, int col, boolean[][] reserved){
           if (!reserved[row][col] &&
                !reserved[row][col + 1] &&
                !reserved[row][col + 2]  &&
                !reserved[row][col + 3 ] 
            ) {
                //mark reserved
                reserved[row][col] = true;
                reserved[row][col + 1] = true;
                reserved[row][col + 2] = true;
                reserved[row][col + 3] = true;
                return true;
            }

        return false;
    }

    public int solution(int N, String S) {
        // write your code in Java SE 8
        //row 0 is not used since the seat rows are 1..N
        boolean[][] reserved = new boolean[N+1][10];

        if (S != null && S.length() != 0) {
            //map the reserved string S to the reserved matrix
            String[] reservedSeats = S.split(" ");
            List<int[]> reservedSeatList = new ArrayList<>();

            //map the seat character to number
            for (String reservedSeatStr : reservedSeats) {
                int[] seat = convertToSeat(reservedSeatStr);
                reservedSeatList.add(seat);
            }
            //mark the seat reserved in the reserved matrix
            for (int[] seat : reservedSeatList) {
                int row = seat[0];
                int col = seat[1];
                reserved[row][col] = true;
            }
        }

        //book 4 seats for each row
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (book(i, 1, reserved)) {
                count++;
            }

            if (book(i, 3, reserved)) {
                count++;
            }

            if (book(i, 5, reserved)) {
                count++;
            }
        }

        return count;        
    }
}
