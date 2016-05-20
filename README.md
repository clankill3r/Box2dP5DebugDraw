# Box2dP5DebugDraw
Simple debug draw class for Box 2d in combination with processing

USEAGE:
```java
debugDraw = new Box2dP5DebugDraw(box2d, g);
 
debugDraw.setFlags(
        DebugDraw.e_shapeBit +
        DebugDraw.e_jointBit
        //DebugDraw.e_aabbBit
        //DebugDraw.e_pairBit +
        //DebugDraw.e_centerOfMassBit +
        //DebugDraw.e_dynamicTreeBit +
        //DebugDraw.e_wireframeDrawingBit
 
); 
box2d.world.setDebugDraw(debugDraw);



colorMode(RGB, 1, 1, 1);
box2d.world.drawDebugData();
```

