package app.entties;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "credit_cards")
public class CreditCard extends BillingDetail{

    private String cardType;
    private Integer expirationMont;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public Integer getExpirationMont() {
        return expirationMont;
    }

    public void setExpirationMont(Integer expirationMont) {
        this.expirationMont = expirationMont;
    }

    @Column(name = "expirationYear")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
