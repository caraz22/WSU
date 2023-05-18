using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WallManager : MonoBehaviour
{
    public List<GameObject> wallPrefabs;

    private const float wallSeparationZ = -5.0f;
    public float speed = 1.0f;
    public float speedIncrease = 0.3f;
    private int wallRowNumber = 0;
    private float timeSinceLastWall = 0.0f;

    private void AddWall() 
    {
            int randomIndex = Random.Range(0, wallPrefabs.Count);
            wallRowNumber += 1;
            Vector3 nextWallPosition = wallPrefabs[randomIndex].transform.position;
            nextWallPosition.z += wallSeparationZ * wallRowNumber;        
            Instantiate(wallPrefabs[randomIndex], nextWallPosition, Quaternion.identity, gameObject.transform);
            if (10 < gameObject.transform.childCount)
            {
                gameObject.transform.getChild(0).Destroy();
            }
    }

    // Start is called before the first frame update
    void Start()
    {
        AddWall();
        AddWall();
        AddWall();
        AddWall();
        // Vector3 nextWallPosition = wallPrefabs[0].transform.position;
        // Instantiate(wallPrefabs[0], nextWallPosition, Quaternion.identity, gameObject.transform);
        
        // wallRowNumber += 1;
        // nextWallPosition = wallPrefabs[1].transform.position;
        // nextWallPosition.z += wallSeparationZ + wallRowNumber;
        // Instantiate(wallPrefabs[1], nextWallPosition, Quaternion.identity, gameObject.transform);
        
        // wallRowNumber += 1;
        // nextWallPosition = wallPrefabs[2].transform.position;
        // nextWallPosition.z += wallSeparationZ * wallRowNumber;        
        // Instantiate(wallPrefabs[2], nextWallPosition, Quaternion.identity, gameObject.transform);
    }

    // Update is called once per frame
    void Update()
    {
        Vector3 currentPosition = transform.position;
        currentPosition.z += speed * Time.deltaTime;
        transform.position = currentPosition;

        timeSinceLastWall += Time.deltaTime;
        if (1.0f < timeSinceLastWall)
        {
            int randomIndex = Random.Range(0, wallPrefabs.Count);
            wallRowNumber += 1;
            Vector3 nextWallPosition = wallPrefabs[randomIndex].transform.position;
            nextWallPosition.z += wallSeparationZ * wallRowNumber;        
            Instantiate(wallPrefabs[randomIndex], nextWallPosition, Quaternion.identity, gameObject.transform);
            timeSinceLastWall = 0.0;
            speed += speedIncrease;
        }
    }
}
