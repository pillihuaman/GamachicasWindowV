package common.System.controller;

import org.apache.tiles.template.AddAttributeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.System.BusinessEntity.CrudImagenBE;
import domain.System.BusinessEntity.ViewStockBE;
import domain.System.BusinessEntity.Base.Clothingline;
import domain.System.BusinessEntity.Base.Imagen;
import model.system.repository.ImagenRepository;
import model.system.repository.stockClothes;

@Controller("/Imagen")
public class ImagenController {
	
	   @RequestMapping(value = "/RegisterImagen", method = RequestMethod.GET)
	   public ModelAndView student( ModelMap mod) {
		   stockClothes stockClothes= new stockClothes();
		   mod.addAttribute("ListClothesLine", stockClothes.ListClothesLine());
		   mod.addAttribute("Mensaje", "Registra informacion basica");
		   ViewStockBE mdod = new ViewStockBE();
		   Clothingline ob = new Clothingline();
		   Imagen img = new Imagen();
		   mdod.setClothingline(ob);
		   mdod.setImagen(img);
		   
		   return new ModelAndView("RegisterImagen", "command", new ViewStockBE());
		   
	   }
	   
	   @RequestMapping(value = "/setDetailImagen", method = RequestMethod.GET)
	   public ModelAndView setDetailImagen( ModelMap mod) {
		   ViewStockBE mdod = new ViewStockBE();
		   Clothingline ob = new Clothingline();
		   mdod.setClothingline(ob);
		   return new ModelAndView("setDetailImagen", "command", new ViewStockBE());
		   
	   }
	   @RequestMapping(value = "/addImagen", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("command")ViewStockBE ViewStockBE,
	   ModelMap model) {
     	ViewStockBE objs= new ViewStockBE();
     	ImagenRepository insert= new ImagenRepository();
    	stockClothes stockClothes= new stockClothes();
    	CrudImagenBE crud= new CrudImagenBE();
    	crud.setClothingline(ViewStockBE.getClothingline());
    	crud.setImagen(ViewStockBE.getImagen());
    	crud.setTest(ViewStockBE.getTest());
    	int test=insert.tesinsert(crud);
    	int idiamgen=insert.registerImagen(crud);
    	stockClothes.getViewStock(objs);
       return "addImagen";
	      
	   }
	   @RequestMapping(value = "/PostImg", method = RequestMethod.POST)
	   public String PostImg(@ModelAttribute("command")ViewStockBE ViewStockBE,
	   ModelMap model) {
         int idclothingline=ViewStockBE.getClothingline().getIdclothingline();
     	ViewStockBE objs= new ViewStockBE();
    	stockClothes stockClothes= new stockClothes();
    	stockClothes.getViewStock(objs);
       return "addImagen";
	      
	   }
	
}
