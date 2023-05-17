using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    public float sideMotionSpeed = 0.5f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey("left")) 
        {
            Vector3 currentPosition = gameObject.transform;
            currentPosition.x += sideMotionSpeed * Time.deltaTime;
            gameObject.transform.position = currentPosition;
        } else if (Input.GetKey("right"))
        {
            Vector3 currentPosition = gameObject.transform.position;
            currentPosition.x -= sideMotionSpeed * Time.deltaTime;
            gameObject.transform.position = currentPosition;
        }
    }
}
