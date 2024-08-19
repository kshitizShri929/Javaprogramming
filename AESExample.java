import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class AESExample {

    private static final String ALGORITHM = "AES";
    private static final Set<String> USERNAME_SET = new HashSet<>();
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$"); 

    public static SecretKey generateKeyFromUsername(String username) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = sha.digest(username.getBytes(StandardCharsets.UTF_8));
        key = java.util.Arrays.copyOf(key, 16); // 128-bit key
        return new SecretKeySpec(key, ALGORITHM);
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty() && USERNAME_PATTERN.matcher(username).matches();
    }

    public static boolean isUsernameUnique(String username) {
        return !USERNAME_SET.contains(username.toLowerCase());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a username (or type 'Q/q' to exit): ");
                String username = scanner.nextLine().trim();

                if (username.equalsIgnoreCase("Q")) {
                    System.out.println("Exited");
                    break;
                }

                if (!isUsernameValid(username)) {
                    System.out.println("Invalid username. Only alphanumeric characters and underscores are allowed.");
                    continue;
                }

                String normalizedUsername = username.toLowerCase();

                if (!isUsernameUnique(normalizedUsername)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    continue;
                }

                USERNAME_SET.add(normalizedUsername);

                SecretKey key = generateKeyFromUsername(username);

                String password = encrypt(username, key);
                System.out.println("Generated Password: " + password);

                String decryptedUsername = decrypt(password, key);
                System.out.println("Decrypted Username: " + decryptedUsername);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

     /*output Sample

Enter a username (or type 'Q/q' to exit): Raj
Generated Password: oSLAYgjiCa7VTAFCfYAMDw==
Decrypted Username: Raj

Enter a username (or type 'Q/q' to exit): Raj12
Generated Password: JxJcPDeh/L2YkuwQS3EkeA==
Decrypted Username: Raj12

Enter a username (or type 'Q/q' to exit): raj
Username already exists. Please choose a different username.
Enter a username (or type 'Q/q' to exit): _raj
Generated Password: n8kAVSScftjYC3MuwNXREw==
Decrypted Username: _raj

Enter a username (or type 'Q/q' to exit): raj@123
Invalid username. Only alphanumeric characters and underscores are allowed.
Enter a username (or type 'Q/q' to exit): 

*/