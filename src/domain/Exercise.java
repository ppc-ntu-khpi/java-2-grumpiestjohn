package domain;

public class Exercise {
    public static String[] Calculate(String CIDR) {
        String[] result = new String[2];
        int maskbits = Integer.parseInt(CIDR.substring(CIDR.lastIndexOf('/') + 1));
        int hostbits = 32 - maskbits;
        String[] parts = CIDR.substring(0, CIDR.lastIndexOf('/')).split("\\.");
        int[] abcd = new int[4];
        for (int i = 0; i < 4; i++) {
            abcd[i] = Integer.parseInt(parts[i]);
        }
        int mask = -(1 << hostbits);
        int ip = ((abcd[0] << 24) + (abcd[1] << 16) + (abcd[2] << 8) + abcd[3]) & mask;
        result[0] = ToString(mask);
        result[1] = String.format("%s - %s", ToString(ip + 1), ToString(ip + ~mask - 1));
        return result;
    }
    public static String ToString(int binary) {
        return String.format("%d.%d.%d.%d",
                (binary >> 24) & 0xFF,
                (binary >> 16) & 0xFF,
                (binary >>  8) & 0xFF,
                binary & 0xFF
        );
    }
}
