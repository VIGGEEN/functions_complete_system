import org.junit.Test;

public class ProgramTest {

    @Test
    public void MakeBidTest(){
        Program _program = new Program();

        _program.registerNewUser("Viktor");
        _program.registerNewDog("Teddy","Labrador",4,20);
        _program.startAuction("Teddy");
        assert (_program.makeBid("Viktor","Teddy",0) == false);
        assert (_program.makeBid("Viktor","Teddy",1) == true);
        assert (_program.makeBid("Viktor","Teddy",2) == true);
        assert (_program.makeBid("Viktor","Teddy",0) == false);
    }

}