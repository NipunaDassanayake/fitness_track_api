<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/model/Questionnaire.java
package com.fitness_track_api.fitness_track.model;

=======
package com.fit_track_api.fit_track_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/model/Questionnaire.java
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "questionnaire")
<<<<<<< HEAD:src/main/java/com/fitness_track_api/fitness_track/model/Questionnaire.java
=======
    @JsonBackReference
>>>>>>> origin/nipuna:src/main/java/com/fit_track_api/fit_track_api/model/Questionnaire.java
    private List<UserAnswer> userAnswers;


}

