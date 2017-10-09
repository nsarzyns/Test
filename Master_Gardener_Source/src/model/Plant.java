package model;

public class Plant
{
    private int plantID = -1;
    private String plant_species = "";

    // Unsure if this ( v ) should be here
    // private int weekNumber;

    public Plant(int plantID, String plant_species)
    {
        if(plantID <= 0)
        {
            throw new IllegalArgumentException("Plant ID cannot be less than or equal to 0.");
        }
        if(plant_species.equals(""))
        {
            throw new IllegalArgumentException("You must input a plant species, empty fields are unacceptable.");
        }

        this.plantID = plantID;
        this.plant_species = plant_species;
    }

    public void setPlantID(int plantID)
    {
        this.plantID = plantID;
    }

    public int getPlantID()
    {
        return this.plantID;
    }

    public void setPlantSpecies(String plant_species)
    {
        this.plant_species = plant_species;
    }

    public String getPlantSpecies()
    {
        return this.plant_species;
    }
}
