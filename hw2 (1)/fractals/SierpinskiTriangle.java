   /*
      Course: CS 45500
      Name: Alex Lowther
      Email: alowther@pnw.edu
      Assignment: 2
   */

package fractals;
import  renderer.scene.*;

/**
   Create a wireframe model of a Sierpinski triangle.
   <p>
   See <a href="https://en.wikipedia.org/wiki/Sierpinski_triangle" target="_top">
                https://en.wikipedia.org/wiki/Sierpinski_triangle</a>
*/
public class SierpinskiTriangle extends Model
{
   /**
      Create an equilateral Sierpinski triangle in the xy-plane
      with {@code n} subdivisions and with its corners on the
      unit circle.

      @param n  number of subdivisions for this triangle
   */
   public SierpinskiTriangle(final int n)
   {
      this(new Vertex(Math.cos(0),
                      Math.sin(0),
                      0.0),
           new Vertex(Math.cos(2*Math.PI/3),
                      Math.sin(2*Math.PI/3),
                      0.0),
           new Vertex(Math.cos(4*Math.PI/3),
                      Math.sin(4*Math.PI/3),
                      0.0),
           n);
   }


   /**
      Create an equilateral Sierpinski triangle in the xy-plane
      with {@code n} subdivisions, with its corners on the unit
      circle and rotated by angle {@code theta} degrees.

      @param theta  rotation (in degrees) of the equilateral triangle
      @param n      number of subdivisions for this triangle
   */
   public SierpinskiTriangle(final double theta, final int n)
   {
      this(new Vertex(Math.cos(theta),
                      Math.sin(theta),
                      0.0),
           new Vertex(Math.cos(theta + 2*Math.PI/3),
                      Math.sin(theta + 2*Math.PI/3),
                      0.0),
           new Vertex(Math.cos(theta + 4*Math.PI/3),
                      Math.sin(theta + 4*Math.PI/3),
                      0.0),
           n);
   }


   /**
      Create a Sierpinski triangle with {@code n}
      subdivisions and its corners at the given
      vertices.

      @param v0  1st {@link Vertex} of the triangle
      @param v1  2nd {@link Vertex} of the triangle
      @param v2  3rd {@link Vertex} of the triangle
      @param n   number of subdivisions for this triangle
   */
   public SierpinskiTriangle(final Vertex v0,
                             final Vertex v1,
                             final Vertex v2,
                             final int n)
   {
      name = "Sierpinski Triangle (n = " + n + ")";

      addVertex(v0, v1, v2);

      sierpinski(0, 1, 2, n);
   }


   /**
      If {@code n > 0}, recursively subdivide the triangle whose
      vertices are indexed by {@code vIndex0}, {@code vIndex1} and
      {@code vIndex2}.
      <p>
      If {@code n == 0}, draw the triangle whose vertices are indexed
      by {@code vIndex0}, {@code vIndex1} and {@code vIndex2}.

      @param vIndex0  index of a {link Vertex} of a triangle
      @param vIndex1  index of a {link Vertex} of a triangle
      @param vIndex2  index of a {link Vertex} of a triangle
      @param n        number of subdivisions for this triangle
   */
   private void sierpinski(final int vIndex0,
                           final int vIndex1,
                           final int vIndex2,
                           final int n)
   {
      
      if(n>0) {
               Vertex v0 = vertexList.get(vIndex0);
               Vertex v1 = vertexList.get(vIndex1);
               Vertex v2 = vertexList.get(vIndex2);
               final int index = vertexList.size();
               final double x0 = v0.x;
               final double y0 = v0.y;
               final double z0 = v0.z;
               final double x1 = v1.x;
               final double y1 = v1.y;
               final double z1 = v1.z;
               final double y2 = v2.y;
               final double x2 = v2.x;
               addVertex(new Vertex(.5*(x0+x1),.5*(y0+y1),z0),
                        new Vertex(.5*(x1+x2),(y1+y2)*.5,z0),
                        new Vertex(.5*(x2+x0),.5*(y2+y0),z0)
                        );

               final int vIndex3 = index + 0;
               final int vIndex4 = index + 1;
               final int vIndex5 = index + 2;
               sierpinski(vIndex0, vIndex3,vIndex5, n-1);
               sierpinski(vIndex1, vIndex3,vIndex4, n-1);
               sierpinski(vIndex2, vIndex5,vIndex4, n-1);

      } else {
               addLineSegment(new LineSegment(vIndex0,vIndex1));
               addLineSegment(new LineSegment(vIndex1,vIndex2));
               addLineSegment(new LineSegment(vIndex2,vIndex0));
      }


   }
}//SierpinskiTriangle
