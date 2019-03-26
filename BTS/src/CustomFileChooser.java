import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class CustomFileChooser extends JFileChooser{
	
    FileNameExtensionFilter GXLfilter = new FileNameExtensionFilter(
	"GXL (Graph eXchange Language)", "gxl");
	  
	public CustomFileChooser() {
	    super();
	    setFileFilter(GXLfilter);
	    setAcceptAllFileFilterUsed(false);
	    setFileSelectionMode(JFileChooser.FILES_ONLY);
	    setSelectedFile(new File(".gxl"));
	  }

	  @Override 
	  public File getSelectedFile() {
	    
		File fileToSave = super.getSelectedFile();
	    if (fileToSave != null) {
	      if (!fileToSave.getName().toLowerCase().endsWith(".gxl"))
	    	  fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".gxl");
	    }
	    return fileToSave;
	  } 

	  @Override 
	  public void approveSelection() {
	    if (getDialogType() == SAVE_DIALOG) {
	      File fileToSave = getSelectedFile();
	      if ((fileToSave != null) && fileToSave.exists()) {
	        int response = JOptionPane.showConfirmDialog(this,
	          "Plik " + fileToSave.getName() + 
	          " ju¿ istnieje. Czy napewno chcesz nadpisac plik?",
	          "Plik istnieje", JOptionPane.YES_NO_OPTION,
	          JOptionPane.WARNING_MESSAGE);
	        if (response != JOptionPane.YES_OPTION)
	          return;
	      }
	    }
	    super.approveSelection();
	  }
}
