package model;

import java.util.List;

public class AnimalData {
    private String name;
    private String picture;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public List<AnimalData> findAll(){
        try {
            return animalRepository.findAll();
            } catch (IOException x) {
            return null;
        }
    }

    public List<AnimalData> findAll() throws IOException{
        List<AnimalData> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for(String line : data)
        {
            String[] words = line.split(",");
            AnimalData a = new AnimalData();
            a.setName(words[0]);
            a.setPicture(words[1]);
            a.setLocation(words[2] + "," + words[3]);
            result.add(a);
        }
        return result;
    }
    @GetMapping("/search")
    public List<AnimalData> search(@RequestParam String name, @RequestParam String Picture, @RequestParam String location)
    {
        try {
            System.out.println(name);
            System.out.println(picture);
            System.out.println(location);
            return animalRepository.find(name, picture, location);
            } catch (IOException e) {
            return null;
        }
    }
}
