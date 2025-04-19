package org.example;

public class EnumClassTest {
    public enum PlainStatus {
        // Normal Enum
        PENDING,    // Just a constant
        APPROVED,   // No additional data
        REJECTED,
    }
    public enum AdvancedStatus {
        // Adding extra fields to the value of ENUM
        PENDING(3, "Earlier"),
        APPROVED(6, "Approved"),
        REJECTED(10, "Last");

        private final int version; // final is not a must, but is still recommended
        String aname;
        // Default is private
        AdvancedStatus(int version, String aname) {
            this.version = version;
            this.aname = aname;
        }

        public int getVersion() {
            return version;
        }

        public String getAname() {
            return aname;
        }
    }
    public static void main(String[] args) {
        System.out.println(PlainStatus.PENDING.name());
        AdvancedStatus.PENDING.aname = "HAHA";
        System.out.println(AdvancedStatus.PENDING.getAname());
        // // error with final
        // AdvancedStatus.PENDING.version = 100;
        System.out.println(AdvancedStatus.PENDING);
        AdvancedStatus tmp = AdvancedStatus.PENDING;
    }
}
