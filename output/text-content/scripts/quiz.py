#!/usr/bin/env python3
"""Standalone quiz runner for the text-content skill.

Usage:
    python quiz.py                    # run all questions
    python quiz.py -n 10              # run 10 questions
    python quiz.py -d hard            # hard questions only
"""

import argparse
import random
import sys
from pathlib import Path

import yaml


def load_questions(path: Path | None = None):
    if path is None:
        path = Path(__file__).parent.parent / "assets" / "quiz.yaml"
    with open(path, encoding="utf-8") as f:
        return yaml.safe_load(f) or []


def run_quiz(questions, count=None, difficulty=None, shuffle=True):
    if difficulty:
        questions = [q for q in questions if q.get("difficulty") == difficulty]
    if shuffle:
        random.shuffle(questions)
    if count:
        questions = questions[:count]
    if not questions:
        print("No questions match the given filters.")
        return

    score = 0
    total = len(questions)

    for i, q in enumerate(questions, 1):
        q_type = q.get("type", "short_answer")
        diff = q.get("difficulty", "medium")
        print(f"\n--- Q{i}/{total} ---  {diff.upper()}  ({q_type})")
        print(f"\n  {q[\'question\']}")

        if q.get("options"):
            for opt in q["options"]:
                print(f"    {opt}")

        user_answer = input("\n  Answer > ").strip()
        print(f"\n  Correct answer: {q.get(\'answer\', \'N/A\')}")
        if q.get("explanation"):
            print(f"  Explanation: {q[\'explanation\']}")

        correct = input("  Did you get it right? (y/n) > ").strip().lower()
        if correct == "y":
            score += 1

    pct = (score / total) * 100 if total else 0
    grade = "A+" if pct >= 97 else "A" if pct >= 93 else "A-" if pct >= 90 else \
            "B+" if pct >= 87 else "B" if pct >= 83 else "B-" if pct >= 80 else \
            "C+" if pct >= 77 else "C" if pct >= 73 else "C-" if pct >= 70 else \
            "D" if pct >= 60 else "F"
    print(f"\n  Score: {score}/{total} ({pct:.0f}%)  Grade: {grade}")


def main():
    parser = argparse.ArgumentParser(description="Interactive quiz runner")
    parser.add_argument("-n", "--count", type=int, help="Number of questions")
    parser.add_argument("-d", "--difficulty", choices=["easy", "medium", "hard"])
    parser.add_argument("--no-shuffle", action="store_true")
    parser.add_argument("path", nargs="?", help="Path to quiz.yaml")
    args = parser.parse_args()

    path = Path(args.path) if args.path else None
    questions = load_questions(path)
    run_quiz(questions, count=args.count, difficulty=args.difficulty, shuffle=not args.no_shuffle)


if __name__ == "__main__":
    main()
