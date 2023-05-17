using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Rotate : MonoBehaviour
{
    public float rate = 60.0f;
    public float angleDeg = 0.0f;
    public float xFactor = 0.0f;
    public float yFactor = 1.0f;
    public float zFactor = 0.0f;

    void Update() 
    {
        angleDeg += rate * Time.deltaTime;
        this.gameObject.transform.localRotation = Quarternion.Euler(xFactor * angleDeg, yFactor * angleDeg, zFactor * angleDeg);
    }
}