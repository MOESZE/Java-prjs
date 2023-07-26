import java.util.Base64;
import java.util.*;

class BaseDecode {
  public static void main(String[] args) {
    String encodedString = "SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y";
    byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
    String decodedString = new String(decodedBytes);
    System.out.println(decodedString);
    Scanner input = new Scanner(System.in);
    System.out.println("Enter string to encode: ");
    String originalinput = input.nextLine();
    encodedString = Base64.getEncoder().encodeToString(originalinput.getBytes());
    System.out.println("Encoded String is: " + encodedString);
  }
}