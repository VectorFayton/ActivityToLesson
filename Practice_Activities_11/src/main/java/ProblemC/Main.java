package ProblemC;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneBook.PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneBook.PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }
}
class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        if (!nameToPhoneNumbersMap.containsKey(name)) {
            nameToPhoneNumbersMap.put(name, new ArrayList<>(numbers));
        } else {
            nameToPhoneNumbersMap.get(name).addAll(numbers);
        }
    }

    public void printPhoneBook() {
        for (String name : nameToPhoneNumbersMap.keySet()) {
            System.out.println(name + ":");
            for (PhoneNumber number : nameToPhoneNumbersMap.get(name)) {
                System.out.println("\t" + number.getType() + ": " + number.getNumber());
            }
        }
    }

    enum PhoneNumberType {
        MOBILE, HOME, WORK
    }

    static class PhoneNumber {
        private final PhoneNumberType type;
        private final String number;

        public PhoneNumber(PhoneNumberType type, String number) {
            this.type = type;
            this.number = number;
        }

        public PhoneNumberType getType() {
            return type;
        }

        public String getNumber() {
            return number;
        }
    }
}

