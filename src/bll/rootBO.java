package bll;

import java.io.IOException;

import dal.rootDAO;

public class rootBO {
	  private rootDAO rootDAO;

	    public rootBO(rootDAO rootDAO) {
	        this.rootDAO = rootDAO;
	    }

	    public String[] readRootsFromFile() throws IOException {
	    	return rootDAO.readRootsFromFile();
	    }
	}