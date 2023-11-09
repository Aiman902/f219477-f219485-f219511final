package bll;

import java.io.IOException;

import dal.PoemDAO;
import dal.RootDAO;

public class RootBO {
	  private RootDAO rootDAO;

	    public RootBO(RootDAO rootDAO) {
	        this.rootDAO = rootDAO;
	    }

	    public String[] readRootsFromFile() throws IOException {
	    	return rootDAO.readRootsFromFile();
	    }
	}

