package bll;

import dal.poemDAO;

public class poemBO {

    private poemDAO poemdao;

    public poemBO(poemDAO poemdao) {
        this.poemdao = poemdao;
    }

    public void addPoem(String Poem) {
        poemdao.addPoem(Poem);
    }


}
