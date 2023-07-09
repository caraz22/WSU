Euler points  

Translation/position, rotation, scale  

Scale factor should be the uniform  

You need one more dimension than the number of dimensions you're working with  

Quaternions: working with 3D, need a fourth dimension   

Perspective: size of something closer will appear to be larger than something farther away
Orthographic: opposite of perspective, size of something closer will be the same size as something that is farther away  

```
self.gameObject.transform.Rotate(0, rate, Space.Self);
==
self.gameObject.transform.localRotation = Quarternion.Euler(0, rate, 0); 
```
or
```
self.gameObject.transform.Rotate(0, rate, Space.World);
==
self.gameObject.transform.rotation = Quarternion.Euler(0, rate, 0);
```

Coordinate system changes are relative to the origin  

Delta time = time from one frame to another; used to move at constant rates  

Comments should by used to tell __why__ the commented section has been integrated into your code  

prefabs: something about creating a copy?  

3D units do not have a predetermined definition?  

arbitrary values are values that if changed, they do not break the game  

turning in: delete library folder (if it exists)  

assets are anything that have values, things that take time and money to create  

manifold is a shape that if you we're to fill it up with water, the water could get everywhere inside the shape without a leak, i.e. a beach ball  

3D warehouse for 3D models to use in unity