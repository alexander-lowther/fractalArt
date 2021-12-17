/*

*/

import fractals.*;
import renderer.scene.*;
import renderer.models.*;
import renderer.pipeline.*;
import renderer.framebuffer.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

/**

*/
public class InteractiveModelsAll implements KeyListener, ComponentListener {
   private final FrameBufferPanel fbp; // The event handlers need
   private final Scene scene; // access to these fields.
   private final List<Model> modelArray = new ArrayList<>();
   private int currentModel = 0;
   private double deltaX = 0.0;
   private double deltaY = 0.0;
   private double deltaZ = 0.0;
   private double deltaS = 1.0;
   private boolean displayTransformations = false;

   /**
    * This constructor instantiates the Scene object
    * and initializes it with appropriate geometry.
    * Then this constructor instantiates the GUI.
    */
   public InteractiveModelsAll() {
      // Create the Scene object that we shall render
      scene = new Scene();

      modelArray.add(new Canopy(30, 0));
      modelArray.add(new Canopy(31, 1));
      modelArray.add(new Canopy(32, 2));
      modelArray.add(new Canopy(33, 3));
      modelArray.add(new Canopy(34, 4));
      modelArray.add(new Canopy(35, 5));
      modelArray.add(new Canopy(36, 6));
      modelArray.add(new Canopy(37, 7));
      modelArray.add(new Canopy(38, 8));
      modelArray.add(new Canopy(39, 9));
      modelArray.add(new Canopy(40, 10));
      modelArray.add(new Canopy(41, 11));
      modelArray.add(new Canopy(42, 12));
      modelArray.add(new Canopy(43, 13));
      modelArray.add(new Canopy(44, 14));
      modelArray.add(new Canopy(45, 15));
      modelArray.add(new Canopy(46, 16));

      // ModelShading.setRandomColor(modelArray.get(0));

      modelArray.add(new KochCurve(0));
      modelArray.add(new KochCurve(1));
      modelArray.add(new KochCurve(2));
      modelArray.add(new KochCurve(3));
      modelArray.add(new KochCurve(4));
      modelArray.add(new KochCurve(5));
      modelArray.add(new KochCurve(6));
      modelArray.add(new KochCurve(7));

      modelArray.add(new H_Tree(0));
      modelArray.add(new H_Tree(1));
      modelArray.add(new H_Tree(2));
      modelArray.add(new H_Tree(3));
      modelArray.add(new H_Tree(4));
      modelArray.add(new H_Tree(5));
      modelArray.add(new H_Tree(6));
      modelArray.add(new H_Tree(7));
      modelArray.add(new H_Tree(8));
      modelArray.add(new H_Tree(9));
      modelArray.add(new H_Tree(10));
      modelArray.add(new H_Tree(11));
      modelArray.add(new H_Tree(12));
      modelArray.add(new H_Tree(13));
      modelArray.add(new H_Tree(14));
      modelArray.add(new H_Tree(15));
      modelArray.add(new H_Tree(16));

      modelArray.add(new SierpinskiTriangle(0));
      modelArray.add(new SierpinskiTriangle(1));
      modelArray.add(new SierpinskiTriangle(2));
      modelArray.add(new SierpinskiTriangle(3));
      modelArray.add(new SierpinskiTriangle(4));
      modelArray.add(new SierpinskiTriangle(5));
      modelArray.add(new SierpinskiTriangle(6));
      modelArray.add(new SierpinskiTriangle(7));
      modelArray.add(new SierpinskiTriangle(8));
      modelArray.add(new SierpinskiTriangle(9));
      modelArray.add(new SierpinskiTriangle(10));

      modelArray.add(new BoxFractal(0));
      modelArray.add(new BoxFractal(1));
      modelArray.add(new BoxFractal(2));
      modelArray.add(new BoxFractal(3));
      modelArray.add(new BoxFractal(4));
      modelArray.add(new BoxFractal(5));
      modelArray.add(new BoxFractal(6));
      modelArray.add(new BoxFractal(7));
      modelArray.add(new BoxFractal(8));

      modelArray.add(new C_Curve(0));
      modelArray.add(new C_Curve(1));
      modelArray.add(new C_Curve(2));
      modelArray.add(new C_Curve(3));
      modelArray.add(new C_Curve(4));
      modelArray.add(new C_Curve(5));
      modelArray.add(new C_Curve(6));
      modelArray.add(new C_Curve(7));
      modelArray.add(new C_Curve(8));
      modelArray.add(new C_Curve(9));
      modelArray.add(new C_Curve(10));
      modelArray.add(new C_Curve(11));
      modelArray.add(new C_Curve(12));
      modelArray.add(new C_Curve(13));
      modelArray.add(new C_Curve(14));
      modelArray.add(new C_Curve(15));
      modelArray.add(new C_Curve(16));
      modelArray.add(new C_Curve(17));
      modelArray.add(new C_Curve(18));
      modelArray.add(new C_Curve(19));
      modelArray.add(new C_Curve(20));

      modelArray.add(new PythagorasTree(0.4, 0.45, 0));
      modelArray.add(new PythagorasTree(0.4, 0.45, 1));
      modelArray.add(new PythagorasTree(0.4, 0.45, 2));
      modelArray.add(new PythagorasTree(0.4, 0.45, 3));
      modelArray.add(new PythagorasTree(0.4, 0.45, 4));
      modelArray.add(new PythagorasTree(0.4, 0.45, 5));
      modelArray.add(new PythagorasTree(0.4, 0.45, 6));
      modelArray.add(new PythagorasTree(0.4, 0.45, 7));
      modelArray.add(new PythagorasTree(0.4, 0.45, 8));
      modelArray.add(new PythagorasTree(0.4, 0.45, 9));
      modelArray.add(new PythagorasTree(0.4, 0.45, 10));
      modelArray.add(new PythagorasTree(0.4, 0.45, 11));
      modelArray.add(new PythagorasTree(0.4, 0.45, 12));
      modelArray.add(new PythagorasTree(0.4, 0.45, 13));
      modelArray.add(new PythagorasTree(0.4, 0.45, 14));
      modelArray.add(new PythagorasTree(0.4, 0.45, 15));

      // Add a model to the Scene.
      scene.addModel(modelArray.get(currentModel));

      // Push the models away from where the camera is.
      for (final Model m : modelArray) {
         for (int i = 0; i < m.vertexList.size(); ++i) {
            final Vertex v = m.vertexList.get(i);
            m.vertexList.set(i, new Vertex(v.x,
                  v.y,
                  v.z - 1));
         }
      }

      Rasterize_Clip.doClipping = true;

      // Define initial dimensions for a FrameBuffer.
      final int width = 1024;
      final int height = 1024;

      // Create a FrameBufferPanel that holds a FrameBuffer.
      fbp = new FrameBufferPanel(width, height);

      // Create a JFrame that will hold the FrameBufferPanel.
      final JFrame jf = new JFrame("Renderer 2");
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // jf.setLocationByPlatform(true);
      // Place the FrameBufferPanel in the JFrame.
      jf.getContentPane().add(fbp, BorderLayout.CENTER);
      jf.pack();
      jf.setVisible(true);

      // Register this object as the event listener for JFrame events.
      jf.addKeyListener(this);
      jf.addComponentListener(this);
   }

   // Implement the KeyListener interface.
   @Override
   public void keyPressed(KeyEvent e) {
   }

   @Override
   public void keyReleased(KeyEvent e) {
   }

   @Override
   public void keyTyped(KeyEvent e) {
      // System.out.println( e );

      final char c = e.getKeyChar();
      if ('h' == c) {
         print_help_message();
         return;
      } else if ('d' == c) {
         Pipeline.debug = !Pipeline.debug;
         // modelArray.get(currentModel).debug = ! modelArray.get(currentModel).debug;
      } else if ('D' == c) {
         Rasterize_Clip.debug = !Rasterize_Clip.debug;
      } else if ('i' == c) {
         final int verts = scene.getModel(0).vertexList.size();
         final int lines = scene.getModel(0).lineSegmentList.size();
         System.out.print("The current Model has " + verts + " vertices and ");
         System.out.println(lines + " line segments.");
      } else if ('c' == c) {
         Rasterize_Clip.doClipping = !Rasterize_Clip.doClipping;
         System.out.print("Clipping is turned ");
         System.out.println(Rasterize_Clip.doClipping ? "On" : "Off");
      } else if ('/' == c) {
         currentModel = (currentModel + 1) % modelArray.size();
         scene.setModel(0, modelArray.get(currentModel));
      } else if ('?' == c) {
         currentModel = (currentModel - 1);
         if (currentModel < 0)
            currentModel = modelArray.size() - 1;
         scene.setModel(0, modelArray.get(currentModel));
      } else if ('p' == c) {
         scene.camera.perspective = !scene.camera.perspective;
         final String p = scene.camera.perspective ? "perspective" : "orthographic";
         System.out.println("Using " + p + " projection");
      } else if ('m' == c) // display transformation information
      {
         displayTransformations = !displayTransformations;
      } else if ('s' == c) // Scale ALL the models 10% smaller.
      {
         // This does NOT work with perspective projection.
         scaleModels(1.0 / 1.1);
      } else if ('S' == c) // Scale ALL the models 10% larger.
      {
         // This does NOT work with perspective projection.
         scaleModels(1.1);
      } else if ('x' == c) // Translate ALL the models.
      {
         moveModels(-0.1, 0, 0); // left
      } else if ('X' == c) {
         moveModels(+0.1, 0, 0); // right
      } else if ('y' == c) {
         moveModels(0, -0.1, 0); // down
      } else if ('Y' == c) {
         moveModels(0, +0.1, 0); // up
      } else if ('z' == c) {
         moveModels(0, 0, -0.1); // back
      } else if ('Z' == c) {
         moveModels(0, 0, +0.1); // forward
      }

      if (displayTransformations && ('m' == c
            || 's' == c || 'x' == c || 'y' == c || 'z' == c
            || 'S' == c || 'X' == c || 'Y' == c || 'Z' == c)) {
         System.out.printf("deltaX = %.2f, deltaY = %.2f, " +
               "deltaZ = %.2f, deltaS = %.2f\n",
               deltaX, deltaY,
               deltaZ, deltaS);
      }

      // Render again.
      final FrameBuffer fb = fbp.getFrameBuffer();
      fb.clearFB();
      Pipeline.render(scene, fb);
      fbp.update();
   }

   private void scaleModels(double deltaS) {
      this.deltaS *= deltaS;
      for (final Model m : modelArray) {
         for (int i = 0; i < m.vertexList.size(); ++i) { // This does NOT work with perspective projection.
            final Vertex v = m.vertexList.get(i);
            m.vertexList.set(i, new Vertex(v.x * deltaS,
                  v.y * deltaS,
                  v.z * deltaS));
         }
      }
   }

   private void moveModels(double deltaX, double deltaY, double deltaZ) {
      this.deltaX += deltaX;
      this.deltaY += deltaY;
      this.deltaZ += deltaZ;
      for (final Model m : modelArray) {
         for (int i = 0; i < m.vertexList.size(); ++i) {
            final Vertex v = m.vertexList.get(i);
            m.vertexList.set(i, new Vertex(v.x + deltaX,
                  v.y + deltaY,
                  v.z + deltaZ));
         }
      }
   }

   // Implement the ComponentListener interface.
   @Override
   public void componentMoved(ComponentEvent e) {
   }

   @Override
   public void componentHidden(ComponentEvent e) {
   }

   @Override
   public void componentShown(ComponentEvent e) {
   }

   @Override
   public void componentResized(ComponentEvent e) {
      // System.out.println( e );

      System.out.printf("JFrame [w = %d, h = %d]: " +
            "FrameBufferPanel [w = %d, h = %d].\n",
            fbp.getTopLevelAncestor().getWidth(),
            fbp.getTopLevelAncestor().getHeight(),
            fbp.getWidth(), fbp.getHeight());

      // Get the new size of the FrameBufferPanel.
      final int w = fbp.getWidth();
      final int h = fbp.getHeight();

      // Create a new FrameBuffer that fits the FrameBufferPanel.
      final FrameBuffer fb = new FrameBuffer(w, h);
      fbp.setFrameBuffer(fb);
      Pipeline.render(scene, fb);
      fbp.update();
   }

   /**
    * Create an instance of this class which has
    * the affect of creating the GUI application.
    */
   public static void main(String[] args) {
      print_help_message();

      // We need to call the program's constructor in the
      // Java GUI Event Dispatch Thread, otherwise we get a
      // race condition between the constructor (running in
      // the main() thread) and the very first ComponentEvent
      // (running in the EDT).
      javax.swing.SwingUtilities.invokeLater(
            () -> new InteractiveModelsAll());
   }

   private static void print_help_message() {
      System.out.println("Use the 'd/D' keys to toggle debugging information on and off for the current model.");
      System.out.println("Use the 'i' key to get information about the current model.");
      System.out.println("Use the '/' key to cycle through the models.");
      System.out.println("Use the 'p' key to toggle between parallel and orthographic projection.");
      System.out.println("Use the x/X, y/Y, z/Z, keys to translate the models along the x, y, z axes.");
      System.out.println("Use the s/S keys to scale the size of the models.");
      System.out.println("Use the 'm' key to toggle the display of transformation information.");
      System.out.println("Use the 'c' key to toggle line clipping on and off.");
      System.out.println("Use the 'h' key to redisplay this help message.");
   }
}
