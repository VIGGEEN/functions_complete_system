import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Auction {

    private Dog dog;
    private int auctionNumber;
    private ArrayList<Bid> bidList;

    public Auction(Dog dog, int auctionNumber) {
        this.dog = dog;
        this.auctionNumber = auctionNumber;
        bidList = new ArrayList<>();
    }

    public int getAuctionNumber() {
        return auctionNumber;
    }

    public String getDogName() {
        return dog.getName();
    }

    public Dog getDog() {
        return dog;
    }

    public boolean isBidListEmpty() {
        return bidList.isEmpty();
    }

    public Bid getHighestBid() {
        return bidList.get(0);
    }

    public void addBid(Bid bid) {
        for (Bid b : bidList) {
            if (bid.getBidder().equals(b.getBidder())) {
                bidList.remove(b);
                break;
            }
        }
        bidList.add(bid);
        Collections.sort(bidList);
        Bid[] topBid = new Bid[3];

        for (int i = topBid.length - 1; i > 0; i--) {
            topBid[i] = topBid[i - 1];
        }
        topBid[0] = bid;

        Bid[] tempBidArray = new Bid[topBid.length * 2];
        for (int i = 0; i < topBid.length; i++) {
            tempBidArray[i] = topBid[i];

        }
        topBid = tempBidArray;


        //topBid = new Bid[6];
        // h�r vill vi l�gga in i listan topbid
        //sortera listan med arraysort
    }

    public ArrayList<Bid> getBid() {
        return bidList;
    }

    public int getTopBid() {
        return bidList.size() > 0 ? Collections.max(bidList).getOffer() : 0;
    }

    public String toString() {
        return ("Auction # " + auctionNumber + ": " + getDogName() + " Top bids: " + bidList);
    }
}


