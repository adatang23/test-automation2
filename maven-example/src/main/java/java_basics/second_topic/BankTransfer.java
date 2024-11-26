package java_basics.second_topic;

import java.util.Objects;
public class BankTransfer extends Payment {
    private String bankName;

    public BankTransfer(String userId, String date, double price, String bankName) {
        super(userId, date, price);
        this.bankName = bankName;
    }

    public final String getBankName() {
        return bankName;
    }

    @Override
    public String toString() {
        return "The user with an ID of " + getUserId()
                + " paid $" + getPrice()
                + " through " + bankName
                + " bank transfer on " + getDate() + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getDate(), getPrice(), bankName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            BankTransfer bankTransfer = (BankTransfer) obj;
            return (bankTransfer.getUserId().equals(this.getUserId())
                    && bankTransfer.getDate().equals(this.getDate())
                    && bankTransfer.getPrice() == this.getPrice()
                    && bankTransfer.bankName.equals(this.bankName));
        }
    }
}
