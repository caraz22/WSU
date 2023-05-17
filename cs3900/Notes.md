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

