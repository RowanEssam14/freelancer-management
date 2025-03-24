import { Freelancer } from './Freelancer';

export interface Project {
  id: number;
  title: string;
  description: string;
  technologiesUsed: string[];
  freelancer: Freelancer;
}