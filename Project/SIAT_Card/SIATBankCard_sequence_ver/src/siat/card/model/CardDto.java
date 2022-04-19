package siat.card.model;

public class CardDto {
	int no;
	String cardName;
	String cardType;
	int annualFee;
	int cardRecord;
	String profit;
	
	public CardDto() {
		
	}
	
	
	public CardDto(int no, String cardName, String cardType, int annualFee, int cardRecord, String profit) {
		this.no = no;
		this.cardName = cardName;
		this.cardType = cardType;
		this.annualFee = annualFee;
		this.cardRecord = cardRecord;
		this.profit = profit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getAnnualFee() {
		return annualFee;
	}

	public void setAnnualFee(int annualFee) {
		this.annualFee = annualFee;
	}

	public int getCardRecord() {
		return cardRecord;
	}

	public void setCardRecord(int cardRecord) {
		this.cardRecord = cardRecord;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "CardDto [no=" + no + ", cardName=" + cardName + ", cardType=" + cardType + ", annualFee=" + annualFee
				+ ", cardRecord=" + cardRecord + ", profit=" + profit + "]";
	}
	
}
