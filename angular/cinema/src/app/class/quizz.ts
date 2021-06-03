export class Quizz {
    id:number;
    theme:string;
    question:string;
    answer1:string;
    answer2:string;
    answer3:string;
    answer4:string;
    trueAnswer:string;
    explanation:string;
    wikiUrl:string;


    constructor(quizzJSON:any){
        this.id = quizzJSON.id;
        this.question = quizzJSON.question
        this.answer1 = quizzJSON.answer1
        this.answer2 = quizzJSON.answer2
        this.answer3 = quizzJSON.answer3
        this.answer4 = quizzJSON.answer4
        this.trueAnswer = quizzJSON.trueAnswer
        this.explanation = quizzJSON.explanation
        this.wikiUrl = quizzJSON.wikiUrl
    }
}
