package domain.System.BusinessEntity.BusinessLogic;



import domain.System.BusinessEntity.CrudImagenBE;

import repository.System.DataAccess.MySql.ImagenDa;


public class ImagenBL {
	  public static  int registerImagen(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.registerImagen(CrudImagenBE);
	    }
	  public static  int tesinsert(CrudImagenBE CrudImagenBE) 
	    { 
	        return ImagenDa.tesinsert(CrudImagenBE);
	    }

}
