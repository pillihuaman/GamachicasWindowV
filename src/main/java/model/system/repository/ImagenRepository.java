package model.system.repository;

import java.util.List;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.Base.Imagen;
import domain.System.BusinessEntity.BusinessLogic.ImagenBL;
import model.system.Abstract.Iimagen;

public class ImagenRepository implements Iimagen{

	@Override
	public   int registerImagen(CrudImagenBE CrudImagenBE) {
		// TODO Auto-generated method stub
		return ImagenBL.registerImagen(CrudImagenBE);
	}

	@Override
	public int tesinsert(CrudImagenBE CrudImagenBE) {
		// TODO Auto-generated method stub
		return  ImagenBL.tesinsert(CrudImagenBE);
	}

	@Override
	public List<Imagen> listaImagen() {
		// TODO Auto-generated method stub
		return ImagenBL.listImagen();
	}

}
