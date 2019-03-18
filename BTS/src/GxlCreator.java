import java.io.File;
import java.io.IOException;

import net.sourceforge.gxl.GXLDocument;
import net.sourceforge.gxl.GXLEdge;
import net.sourceforge.gxl.GXLGraph;
import net.sourceforge.gxl.GXLNode;

public class GxlCreator {
		
	
		public static void writeGXL(File fileToSave){

			GXLDocument gxlDocument = new GXLDocument();
			GXLGraph graph = new GXLGraph("BTSgraph");
			
			GXLNode [] nodes = new GXLNode[Bts.BtsList.size()];
			GXLEdge [] edges = new GXLEdge[Bts.EdgeList.size()];		
			
			for (int i=0;i<nodes.length;i++) {
				String name = "node"+Integer.toString(Bts.BtsList.get(i).getName());
				nodes[i]=new GXLNode(name);
				
			}
			
			for (int i=0;i<edges.length;i++) {
				int start = Bts.EdgeList.get(i).getStartPoint().getName()-1;
				int end = Bts.EdgeList.get(i).getEndPoint().getName()-1;
				edges[i]=new GXLEdge(nodes[start],nodes[end]);
				
			}
						
			for (int i=0;i<nodes.length;i++) {
			graph.add(nodes[i]);
			}
			
			for (int i=0;i<edges.length;i++) {
			graph.add(edges[i]);
			}
			
			gxlDocument.getDocumentElement().add(graph);

			try {
			 gxlDocument.write(fileToSave);

			}
			catch (IOException ioe) {
			 System.out.println("Bl¹d zapisu pliku: " + ioe);
			}
		}
		
	}

