package common.System.controller;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.tiles.template.AddAttributeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	     HttpServletResponse response) throws IOException {
	     //Item item = itemService.get(itemId);   
		  // HttpServletResponse response=null;
	     //response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	  	ViewStockBE objs= new ViewStockBE();
		ImagenRepository insert= new ImagenRepository();
    	stockClothes stockClothes= new stockClothes();
    	CrudImagenBE crud= new CrudImagenBE();
    	crud.setClothingline(ViewStockBE.getClothingline());
    	crud.setImagen(ViewStockBE.getImagen());
    	crud.setTest(ViewStockBE.getTest());
    	//int test=insert.tesinsert(crud);
    	int idiamgen=insert.registerImagen(crud);
    	stockClothes.getViewStock(objs);
    	List<Imagen> imf  = null;
    	imf=  insert.listaImagen();
	    for (Imagen imagen : imf) {
	    	 response.setContentType("image/jpeg");
	    	  //byte[] buffer = tweetService.getTweetByID(tweetID).getUserImage();
	    	  InputStream in1 = new ByteArrayInputStream(imagen.getImagendata());
	    	 // IOUtils.copy(in1, response.getOutputStream());
		}
	    //response.setContentType("image/jpeg");
	    //byte[] buffer = tweetService.getTweetByID(tweetID).getUserImage();
	    //InputStream in1 = new ByteArrayInputStream(buffer);
	    //IOUtils.copy(in1, response.getOutputStream());
	    
	    //HttpServletResponse response=null;
	    //response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	     //response.getOutputStream().write(null);
	     //response.getOutputStream().close();
	      return "addImagen"; 
	   }
	 /*  @RequestMapping(value = "/addImagen", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("command")ViewStockBE ViewStockBE,
	   ModelMap model) {
     	ViewStockBE objs= new ViewStockBE();
     	ImagenRepository insert= new ImagenRepository();
    	stockClothes stockClothes= new stockClothes();
    	CrudImagenBE crud= new CrudImagenBE();
    	crud.setClothingline(ViewStockBE.getClothingline());
    	crud.setImagen(ViewStockBE.getImagen());
    	crud.setTest(ViewStockBE.getTest());
    	//int test=insert.tesinsert(crud);
    	int idiamgen=insert.registerImagen(crud);
    	stockClothes.getViewStock(objs);
       return "addImagen";
	      
	   }*/
	
	   
	   @RequestMapping(value="/PostImg", method=RequestMethod.POST)
	    public ModelAndView PostImg(@RequestParam("file") MultipartFile file) {
	    try {
	        /**
	         * Set the path where to save the file.
	         * ex. "C:\\images\\" + file.getOriginalFilename() //win
	         * ex. "/images/" + file.getOriginalFilename() //nix
	         */
	        file.transferTo(new File(file.getOriginalFilename()));
	        //successful
	    } catch (IllegalStateException e) {
	        //error
	    } catch (IOException e) {
	        //error
	    }

	    ModelAndView model = new ModelAndView();
	    //set message
	    model.setViewName("index");

	    return model;
	}
	
}
