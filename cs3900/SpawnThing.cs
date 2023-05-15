using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnThing : MonoBehaviour{
    public GameObject thingPrefab;
    
    void DoSpawnThing() 
    {
        GameObject clone = Instantiate(thingPrefab, thingPrefab.transform.position, Quarternion.identity);
    }
    
    void Start() 
    {
        
    }
    void Update() 
    {
        if (Input.GetKeyDown("space"))
        {
            DoSpawnThing();
        }
    }
}