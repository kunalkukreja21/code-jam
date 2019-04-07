import java.math.BigInteger;
import java.util.*;

/**
 * Created by kunalkukreja on 06/04/19.
 */
public class Solution {
    public static void main(String[] args) {
        solveCryptoPangrams();
    }

    private static void solveCryptoPangrams() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t ; ++i) {
            System.out.print("Case #" + (i + 1) + ": ");
            BigInteger n = scanner.nextBigInteger();
            int l = scanner.nextInt();
            List<BigInteger> cipherText = new ArrayList<>();
            for (int j = 0; j < l; ++j) {
                cipherText.add(scanner.nextBigInteger());
            }
            int divPoint = 0;
            for (int j = 0; j < l-1; ++j) {
                if (!cipherText.get(j).equals(cipherText.get(j+1))) {
                    divPoint = j;
                    break;
                }
            }
            BigInteger gcd12 = cipherText.get(divPoint).gcd(cipherText.get(divPoint+1));
            BigInteger current = gcd12;
            List<BigInteger> ans = new ArrayList<>();
            for (int j = divPoint; j >=0; --j) {
                BigInteger newCurrent = cipherText.get(j).divide(current);
                ans.add(newCurrent);
                current = newCurrent;
            }
            Collections.reverse(ans);
            ans.add(gcd12);
            current = gcd12;
            for (int j = divPoint+1; j < l; ++j) {
                BigInteger newCurrent = cipherText.get(j).divide(current);
                ans.add(newCurrent);
                current = newCurrent;
            }
            Set<BigInteger> charSet = new TreeSet<>(ans);
            char curChar = 'A';
            Map<BigInteger, Character> valueToChar = new HashMap<>();
            for (BigInteger charValue: charSet) {
                valueToChar.put(charValue, curChar);
                curChar++;
            }
            for (BigInteger ansValues: ans) {
                System.out.print(valueToChar.get(ansValues));
            }
            System.out.println();
        }
    }

    private static void solveYouCanGoYourOwnWay() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t ; ++i) {
            System.out.print("Case #" + (i + 1) + ": ");
            int n = scanner.nextInt();
            String lydia = scanner.next();
            boolean goSouth = lydia.charAt(lydia.length() - 1) == 'S';
            int myX = 0, myY = 0, lydiaX = 0, lydiaY = 0;
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < 2*n - 2; ++j) {
                boolean samePosition = myX == lydiaX && myY == lydiaY;
                if (lydia.charAt(j) == 'S') {
                    ++lydiaY;
                } else {
                    ++lydiaX;
                }
                if (myX == n-1) {
                    answer.append('S');
                    ++myY;
                } else if (myY == n-1) {
                    answer.append('E');
                    ++myX;
                } else {
                    if (goSouth) {
                        if (samePosition && myY + 1 == lydiaY && myX == lydiaX) {
                            answer.append('E');
                            ++myX;
                        } else {
                            answer.append('S');
                            ++myY;
                        }
                    } else {
                        if (samePosition && myX + 1 == lydiaX && myY == lydiaY) {
                            answer.append('S');
                            ++myY;
                        } else {
                            answer.append('E');
                            ++myX;
                        }
                    }
                }
            }
            System.out.println(answer.toString());
        }
    }

    private static void solveForegoneSolution() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t ; ++i) {
            System.out.print("Case #" + (i+1) + ": ");
            String n = scanner.next();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            boolean found = false;
            for (char c:n.toCharArray()) {
                if (c == '4') {
                    a.append('2');
                    b.append('2');
                    found = true;
                } else {
                    a.append(c);
                    if (found)
                        b.append('0');
                }
            }
            System.out.println(a.toString() + " " + b.toString());
        }
    }
}
