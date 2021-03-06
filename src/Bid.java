
public class Bid implements Comparable<Bid> {

    private User bidder;
    private int offer;

    public Bid(User bidder, int offer) {
        this.bidder = bidder;
        this.offer = offer;
    }

    public User getBidder() {
        return bidder;
    }

    public int getOffer() {
        return offer;
    }


    public String toString() {
        return bidder.getName() + offer + " kr ";
    }

    public int compareTo(Bid bid) {
        return offer - bid.getOffer();
    }

}
