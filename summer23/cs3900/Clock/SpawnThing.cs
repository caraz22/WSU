using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public GameObject thingPrefab;
public GameObject rotatingCube;
public Text scoreText;

private int score = 0;
private List<GameObject> allBalls = new List<GameObjects>();

void DoSpawnThing()
{
    GameObject clone = Instantiate();
}

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