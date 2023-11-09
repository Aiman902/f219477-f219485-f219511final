package bll;

import dal.PoemDAO;

public class PoemBO {
    private PoemDAO poemDAO;

    public PoemBO(PoemDAO poemDAO) {
        this.poemDAO = poemDAO;
    }

    public void addPoem(String Poem) {
        poemDAO.addPoem(Poem);
    }
}
