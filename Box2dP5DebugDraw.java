import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.particle.ParticleColor;
import processing.core.PConstants;
import processing.core.PGraphics;
import shiffman.box2d.Box2DProcessing;

/**
 * Created by doekewartena on 6/30/15.
 */
public class Box2dP5DebugDraw extends DebugDraw {
  
    Box2DProcessing box2d;
    PGraphics g;

    public Box2dP5DebugDraw(Box2DProcessing box2d, PGraphics g) {
      this.box2d = box2d;
      this.g = g;
    }

    @Override
    public void drawPoint(Vec2 argPoint, float argRadiusOnScreen, Color3f argColor) {
        System.out.println("drawPoint");
    }

    @Override
    public void drawSolidPolygon(Vec2[] vertices, int vertexCount, Color3f color) {

        g.noStroke();
        g.fill(color.x, color.y, color.z);

        g.beginShape();
        for (int i = 0; i < vertexCount; i++) {
            Vec2 pixelVec = box2d.coordWorldToPixels(vertices[i]);
            g.vertex(pixelVec.x, pixelVec.y);
        }
        g.endShape();

    }

    @Override
    public void drawCircle(Vec2 center, float radius, Color3f color) {

        center = box2d.coordWorldToPixels(center);
        radius = box2d.scalarWorldToPixels(radius);

        g.ellipseMode(PConstants.CENTER);
        g.stroke(color.x, color.y, color.z);
        g.noFill();
        g.ellipse(center.x, center.y, radius * 2, radius * 2);
    }

    @Override
    public void drawSolidCircle(Vec2 center, float radius, Vec2 axis, Color3f color) {

        center = box2d.coordWorldToPixels(center);
        radius = box2d.scalarWorldToPixels(radius);

        g.ellipseMode(PConstants.CENTER);
        g.fill(color.x, color.y, color.z);
        g.noStroke();
        g.ellipse(center.x, center.y, radius * 2, radius * 2);
    }

    @Override
    public void drawSegment(Vec2 p1, Vec2 p2, Color3f color) {

//        System.out.println();
//        System.out.println("drawSegment");
//        System.out.println(p1.x+" "+p1.y);
//        System.out.println(p2.x+" "+p2.y);
//        System.out.println(color.x+" "+color.y+" "+color.z);
//        System.out.println();

        Vec2 v1 = box2d.coordWorldToPixels(p1);
        Vec2 v2 = box2d.coordWorldToPixels(p2);
        g.stroke(color.x, color.y, color.z);
        g.line(v1.x, v1.y, v2.x, v2.y);

    }

    @Override
    public void drawTransform(Transform transform) {
        System.out.println("drawTransform");
        // we can push a matrix but when do we need to pop?
        // we would need to count the pushes
        // Vec2 p = box2d.coordWorldToPixels(transform.p);
        // System.out.println("p.x: "+p.x+"  p.y: "+p.y);
    }

    @Override
    public void drawString(float x, float y, String s, Color3f color) {
        System.out.println("drawString");
    }

    @Override
    public void drawParticles(Vec2[] centers, float radius, ParticleColor[] colors, int count) {
        System.out.println("drawParticles");
    }

    @Override
    public void drawParticlesWireframe(Vec2[] centers, float radius, ParticleColor[] colors, int count) {
        System.out.println("drawParticlesWireframe");
    }
}
